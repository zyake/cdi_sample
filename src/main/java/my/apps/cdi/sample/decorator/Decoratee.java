package my.apps.cdi.sample.decorator;

/**
 * デコレート対象のインターフェース。
 * デコレータは、実装するインターフェースでデコレート対象を
 * 一意に識別できるため、特別なアノテーションなどは必要ありません。
 */
public interface Decoratee {

    String invoke();
}
