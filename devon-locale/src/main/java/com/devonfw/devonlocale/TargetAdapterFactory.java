package com.devonfw.devonlocale;

import com.devonfw.devonlocale.translator.ExtJsTargetAdapter;
import com.devonfw.devonlocale.translator.JsonTargetAdapter;
import com.devonfw.devonlocale.translator.TranslationTarget;

/**
 * TODO ssarmoka This type ...
 *
 * @author ssarmoka
 */
public class TargetAdapterFactory extends AbstractTargetAdapterFactory {

  public TargetAdapterFactory() {

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public TranslationTarget getTranslationTarget(String outputFormat) {

    TranslationTarget target = null;
    switch (outputFormat) {
    case "extjs":
      target = new ExtJsTargetAdapter();
      break;
    case "angular":
      target = new JsonTargetAdapter();
      break;
    default:
      target = new ExtJsTargetAdapter();
      break;
    }
    return target;
  }

}
