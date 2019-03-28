package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String challangeTopc;

    private String challengeLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChallangeTopc() {
        return challangeTopc;
    }

    public void setChallangeTopc(String challangeTopc) {
        this.challangeTopc = challangeTopc;
    }

    public String getChallengeLink() {
        return challengeLink;
    }

    public void setChallengeLink(String challengeLink) {
        this.challengeLink = challengeLink;
    }
}
