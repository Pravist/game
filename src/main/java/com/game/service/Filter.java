package com.game.service;

import com.game.entity.Profession;
import com.game.entity.Race;

import java.util.Date;

public class Filter {

    private String name;
    private String title;
    private Race race;
    private Profession profession;
    private Date after;
    private Date before;
    private Boolean banned;
    private Integer minExperience;
    private Integer maxExperience;
    private Integer minLevel;
    private Integer maxLevel;
    public static final Long START200MS = 946_684_800_000L; //01.01.2000 00:00:00
    public static final Long END3000MS = 32_535_215_999_000L; //31.12.3000 23:59:59

    public Filter() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Date getAfter() {
        return after;
    }

    public void setAfter(Date after) {
        this.after = after;
    }

    public Date getBefore() {
        return before;
    }

    public void setBefore(Date before) {
        this.before = before;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public Integer getMinExperience() {
        return minExperience;
    }

    public void setMinExperience(Integer minExperience) {
        this.minExperience = minExperience;
    }

    public Integer getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(Integer maxExperience) {
        this.maxExperience = maxExperience;
    }

    public Integer getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Integer minLevel) {
        this.minLevel = minLevel;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public Boolean hasName() {
        return name != null && name.length() > 0;
    }

    public Boolean hasTitle() {
        return title != null && title.length() > 0;
    }

    public Boolean hasRace() {
        return race != null;
    }

    public Boolean hasProfession() {
        return profession != null;
    }

    public Boolean hasAfter() {
        return after != null && isInIntervale(after.getTime(), START200MS, END3000MS);
    }

    public Boolean hasBefore() {
        return before != null && isInIntervale(before.getTime(), START200MS, END3000MS);
    }

    public Boolean hasBanned() {
        return banned != null;
    }

    public Boolean hasMinExperience() {
        return minExperience != null && isInIntervale((long) minExperience, 0L, 10_000_000L);
    }

    public Boolean hasMaxExperience() {
        return maxExperience != null && isInIntervale((long) maxExperience, 0L, 10_000_000L);
    }

    public Boolean hasMinLevel() {
        return minLevel != null && minLevel > 0;
    }

    public Boolean hasMaxLevel() {
        return maxLevel != null && maxLevel > 0;
    }

    public Boolean isMaxMoreThanMinExperience() {
        return maxExperience >= minExperience;
    }

    public Boolean isBeforeMoreThanAfter() {
        return before.after(after);
    }

    public Boolean isMaxLevelMoreThanMinLevel() {
        return maxLevel >= minLevel;
    }

    public static Boolean isInIntervale(Long date, Long startDate, Long endDate) {
        return date >= startDate && date <= endDate;
    }

    public Boolean hasBody() {
        return hasName() || hasTitle() || hasRace() || hasProfession() || hasAfter() || hasBefore() || hasBanned() ||
                hasMinExperience() || hasMaxExperience() || hasMinLevel() || hasMaxLevel();
    }

    public Filter(String name, String title, Race race, Profession profession, Long after,
                  Long before, Boolean banned, Integer minExperience, Integer maxExperience,
                  Integer minLevel, Integer maxLevel) {

        this.name = name;
        this.title = title;
        this.race = race;
        this.profession = profession;
        this.after = after != null ? new Date(after) : null;
        this.before = before != null ? new Date(before) : null;
        this.banned = banned;
        this.minExperience = minExperience;
        this.maxExperience = maxExperience;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
    }
}
