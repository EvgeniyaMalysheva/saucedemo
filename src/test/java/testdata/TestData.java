package testdata;

import static utils.RandomUtils.getRandomPassword;

public class TestData {
    public final static String STANDARD_USER = "standard_user",
            LOCKED_OUT_USER = "locked_out_user",
            PERFORMANCE_GLITCH_USER = "performance_glitch_user",
            STANDARD_PASSWORD = "secret_sauce";

    public static String wrongPassword = getRandomPassword();
}
