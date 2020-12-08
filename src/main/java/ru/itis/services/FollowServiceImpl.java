package ru.itis.services;

import ru.itis.repositories.FollowRepository;

public class FollowServiceImpl implements FollowService {

    private FollowRepository followRepository;

    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public void addEmail(String email) {
        followRepository.addEmail(email);
    }
}
