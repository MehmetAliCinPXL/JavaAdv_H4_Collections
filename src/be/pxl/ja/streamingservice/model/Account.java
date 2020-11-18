package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.exception.TooManyProfilesException;
import be.pxl.ja.streamingservice.util.PasswordUtil;
import com.sun.tools.javac.Main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {
    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private Map<String, Profile> profiles = new HashMap<>();

    public Account(String email, String password) {
        this.email = email;
        setPassword(password);
        Profile profile = new Profile("Profile1");
        profiles.put(profile.getName(), profile);
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void addProfile(Profile profile) {

        if (profiles.size() <= streamingPlan.getNumberOfScreens()) {
            throw new TooManyProfilesException("Maxmimum aantal profielen bereikt");
        }
        profiles.put(profile.getName(), profile);


		/*try {
			if (profiles.size() <= streamingPlan.getNumberOfScreens()) {
				throw new TooManyProfilesException("Maxmimum aantal profielen bereikt");
			}
			profiles.put(profile.getName(), profile);
		} catch (TooManyProfilesException e) {
			System.out.println(e.getMessage());
		}*/
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean verifyPassword(String password) {
        return PasswordUtil.isValid(password, this.password);
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setPassword(String password) {
        this.password = PasswordUtil.encodePassword(password);
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }

    public void show() {
        profiles.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));
    }

    public static void main(String[] args) {
        Account acc = new Account("JohnDoe@example.be", "1234");
        acc.setStreamingPlan(StreamingPlan.BASIC);
        acc.addProfile(new Profile("mehmet"));
        acc.show();

    }
}
