package com.devonfw.devonlocale;

import com.devonfw.devonlocale.translator.TranslationTarget;

/**
 * TODO ssarmoka This type ...
 *
 * @author ssarmoka
 */
public abstract class AbstractTargetAdapterFactory {

  public abstract TranslationTarget getTranslationTarget(String outputFormat);
}
