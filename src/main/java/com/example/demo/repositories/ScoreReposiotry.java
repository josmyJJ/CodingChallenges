package com.example.demo.repositories;

import com.example.demo.beans.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreReposiotry extends CrudRepository<Score, Long> {
}
