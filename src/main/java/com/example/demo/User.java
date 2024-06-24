package com.example.demo;
import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String goal;
    private String city;
    private String zodiac_sign;
    private int height;
    private String education;
    private String children;
    private String preference;
    private String alcohol_preference;
    private String smoking_preference;
    private String bio;
    private String email;
    private String gender;
    private String intent;
    private String password;
    private String photoUrl;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public User(Long id, String name, int age, String goal, String city, String zodiac_sign, String preference, int height, String education, String children, String alcohol_preference, String smoking_preference, String bio, String email, String gender, String intent, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.goal = goal;
        this.city = city;
        this.zodiac_sign = zodiac_sign;
        this.height = height;
        this.education = education;
        this.children = children;
        this.alcohol_preference = alcohol_preference;
        this.smoking_preference = smoking_preference;
        this.preference = preference;
        this.bio = bio;
        this.email = email;
        this.gender = gender;
        this.intent = intent;
        this.password = password;
    }

    public User() {
        this.id = id;
        this.name = name;
        this.age = age;
        this.goal = goal;
        this.city = city;
        this.zodiac_sign = zodiac_sign;
        this.height = height;
        this.preference = preference;
        this.education = education;
        this.children = children;
        this.alcohol_preference = alcohol_preference;
        this.smoking_preference = smoking_preference;
        this.bio = bio;
        this.email = email;
        this.gender = gender;
        this.intent = intent;
        this.password = password;
        this.photoUrl = photoUrl;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZodiac_sign() {
        return zodiac_sign;
    }

    public void setZodiac_sign(String zodiac_sign) {
        this.zodiac_sign = zodiac_sign;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getAlcohol_preference() {
        return alcohol_preference;
    }

    public void setAlcohol_preference(String alcohol_preference) {
        this.alcohol_preference = alcohol_preference;
    }

    public String getSmoking_preference() {
        return smoking_preference;
    }

    public void setSmoking_preference(String smoking_preference) {
        this.smoking_preference = smoking_preference;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
