package in.rajesh.galla;

import in.rajesh.galla.actions.FBSignUpActions;
import org.fluentlenium.core.FluentAdapter;
import org.fluentlenium.core.annotation.Page;

public class PageInjector extends FluentAdapter{

    @Page
    FBSignUpActions fbSignUpActions;

}
