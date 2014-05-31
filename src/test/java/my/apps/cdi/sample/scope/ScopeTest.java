package my.apps.cdi.sample.scope;

import org.junit.Test;

import javax.naming.NamingException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

import static my.apps.cdi.sample.EmbeddedEJBContainerManager.lookup;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ScopeTest {

    @Test
    public void testDependentScope() throws Exception {
        DependentInjectee injectee = lookup(
                "java:global/classes/DependentInjectee");

        // Dependentスコープは擬似スコープと呼ばれ、
        // ノーマル・スコープのオブジェクトと異なり、その都度払いだされます。
        Set<String> beanNames = new HashSet<String>();

        DependentScopeBean dependent1 = injectee.getDependentBean1();
        beanNames.add(dependent1.getName());

        DependentScopeBean dependent2 = injectee.getDependentBean2();
        beanNames.add(dependent2.getName());

        assertEquals(2, beanNames.size());
        assertThat(beanNames,
                allOf(hasItem("Dependent Scoped: instance count=1"),
                        hasItem("Dependent Scoped: instance count=2"))
        );
    }

    @Test
    public void testRequestScope() throws Exception {
        RequestScopeInjectee injectee = lookup(
                "java:global/classes/RequestScopeInjectee");

        // 非同期呼び出し毎に別のオブジェクトが生成、参照されます。
        // EJBのローカルインターフェースは新たなリクエスト・コンテキスト
        // として扱われないようです。
        Set<String> beanNames = new HashSet<String>();

        Future<String> asyncRequest1 = injectee.getName();
        beanNames.add(asyncRequest1.get());

        Future<String> asyncRequest2 = injectee.getName();
        beanNames.add(asyncRequest2.get());

        assertEquals(2, beanNames.size());
        assertThat(beanNames,
                allOf(hasItem("Request Scoped: instance count=1"),
                        hasItem("Request Scoped: instance count=2"))
        );
    }

    @Test
    public void testApplicationScope() throws NamingException {
        ApplicationScopeInjectee injectee = lookup(
                "java:global/classes/ApplicationScopeInjectee");

        // アプリケーション・スコープは、アプリケーションのライフサイクル全体で管理される。
        // ただし、管理範囲は「VM毎」ではなく「アプリケーション毎」なので、
        // 同一VM上でもアプリケーションが異なると、それぞれ別のコンポーネントが
        // 払い出される可能性があるそうです。
        Set<String> beanNames = new HashSet<String>();

        ApplicationScopeBean testBean1 = injectee.getTestBean1();
        beanNames.add(testBean1.getName());

        ApplicationScopeBean testBean2 = injectee.getTestBean2();
        beanNames.add(testBean2.getName());

        // ノーマル・スコープのルールにより、アクティブ・スコープのコンテキストから同一オブジェクトを参照します。
        assertEquals(1, beanNames.size());
        assertThat(beanNames,
            allOf(hasItem("Application Scoped: instance count=1")));

        // クライアント・プロキシ経由のアクセスとなります。
        injectee.printBean1Class();
    }

    @Test
    public void testSingletonScope() throws NamingException {
        SingletonScopeInjectee injectee = lookup(
                "java:global/classes/SingletonScopeInjectee");

        // Singletonのオブジェクトを取得します。
        // 詳細な仕様が定義されているアプリケーション・スコープと異なり、
        // CDIの仕様で言及されておらず、CDIプロバイダ毎に挙動が異なる可能性があるため、
        // あまり使用が推奨されないかもしれません。
        SingletonScopeBean testBean1 = injectee.getTestBean1();
        assertEquals("Singleton Scoped: instance count=1", testBean1.getName());

        SingletonScopeBean testBean2 = injectee.getTestBean2();
        assertEquals("Singleton Scoped: instance count=1", testBean2.getName());

        // シングルトンは擬似スコープなので、直接オブジェクトにアクセスします。
        injectee.printBean1Class();
    }
}
