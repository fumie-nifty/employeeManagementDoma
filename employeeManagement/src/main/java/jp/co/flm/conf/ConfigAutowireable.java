/**
 * ConfigAutowireable.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.conf;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ConfigAutowireable
 * DaoインターフェースをDIコンテナで管理するためのアノテーションを定義するクラス
 * @author kuga
 * @version 1.0 2023/07/12
 */
@AnnotateWith(annotations = { @Annotation(target = AnnotationTarget.CLASS, type = Component.class),
		@Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class) })
public @interface ConfigAutowireable {
}
