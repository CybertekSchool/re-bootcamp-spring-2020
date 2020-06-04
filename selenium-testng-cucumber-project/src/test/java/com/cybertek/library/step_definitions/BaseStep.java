package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.api.AuthenticationUtility;
import com.cybertek.library.utilities.ui.Pages;

import java.util.Map;

public class BaseStep {
    protected AuthenticationUtility authenticationUtility;
    protected Pages pages = new Pages();
    protected static Map<String, Object> user;

}
