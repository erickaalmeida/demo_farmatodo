package com.example.demo.repositories;

import com.example.demo.models.EpisodeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEpisodeRepository extends JpaRepository<EpisodeModel,Long> {
}
