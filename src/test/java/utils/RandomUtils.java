package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
        private static final Faker faker = new Faker(new Locale("en"));

        public static String getRandomPassword() {

                return faker.lorem().characters(10);
        }
}
