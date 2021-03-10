package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(googleauthenticator.actions.CreateCredentials.class);
    registrator.registerUserAction(googleauthenticator.actions.IsCodeValid.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}
