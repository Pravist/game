package com.game.service;

import com.game.controller.PlayerOrder;
import com.game.entity.Profession;
import com.game.entity.Race;
import com.game.service.Filter;

public class PageFilter extends Filter {
    private PlayerOrder order;
    private Integer pageNumber;
    private Integer pageSize;

    public PageFilter() {

    }

    public PageFilter(String name, String title, Race race, Profession profession, Long after,
                      Long before, Boolean banned, Integer minExperience, Integer maxExperience,
                      Integer minLevel, Integer maxLevel, PlayerOrder order, Integer pageNumber, Integer pageSize) {
        super(name, title, race, profession, after, before, banned, minExperience, maxExperience, minLevel, maxLevel);
        this.order = order;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }


    public PlayerOrder getOrder() {
        return order;
    }

    public void setOrder(PlayerOrder order) {
        this.order = order;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean hasOrder() {
        return order != null;
    }

    public Boolean hasPageSize() {
        return pageSize != null;
    }

    public Boolean hasPageNumber() {
        return pageNumber != null;
    }

    @Override
    public Boolean hasBody() {
        return super.hasBody() || hasOrder() || hasPageSize() || hasPageNumber();
    }
}


