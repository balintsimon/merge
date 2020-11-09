package com.codecool.moviereactorapplication.controller;

import com.codecool.moviereactorapplication.entity.Visitor;
import com.codecool.moviereactorapplication.repository.VisitorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codecool.moviereactorapplication.security.CustomUserDetailsService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/watchlist")
public class WatchListController {

    private final VisitorRepository visitorRepository;
    private final CustomUserDetailsService customUserDetailsService;

    public WatchListController(VisitorRepository visitorRepository, CustomUserDetailsService customUserDetailsService) {
        this.visitorRepository = visitorRepository;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping
    public List<Map<String, Integer>> getWatchListByUser(@RequestHeader String username) {
        List<Map<String, Integer>> returnList = new ArrayList<>();
        if (username == null) {
            return null;
        } else {
            List<Integer> idList = visitorRepository.getByUsername(username).getWatchList();

            for (int id : idList) {
                Map<String, Integer> data = new HashMap<>();
                data.put("id", id);
                returnList.add(data);
            }
        }
        return returnList;
    }

    @PostMapping("/save/{movie_db_id}")
    public boolean saveMovieIntoWatchList(@RequestHeader String username, @PathVariable Integer movie_db_id) {
        Visitor visitor;
        if (username != null) {
            visitor = visitorRepository.getByUsername(username);
        } else {
            return false;
        }
        List<Integer> watchList = visitor.getWatchList();
        if (watchList.contains(movie_db_id)) {
            return false;
        }
        watchList.add(movie_db_id);
        visitor.setWatchList(watchList);
        visitorRepository.save(visitor);
        return true;
    }

    @DeleteMapping("/delete/{movie_db_id}")
    public boolean deleteMovieFromWatchList(@PathVariable Integer movie_db_id, @RequestHeader String username) {
        if (!visitorRepository.getByUsername(username).getWatchList().contains(movie_db_id)) {
            return false;
        }
        Visitor visitor = visitorRepository.getByUsername(username);
        List<Integer> watchList = visitor.getWatchList();
        watchList.remove(movie_db_id);
        visitor.setWatchList(watchList);
        visitorRepository.save(visitor);
        return true;
    }


//    @GetMapping("/user/{id}")
//    public List<Long> getWatchListByUser(@PathVariable("user_id") Long userId) {
//        return allVisitors.getWatchListByUser(userId);
//    }
//
//    @GetMapping("/save")
//    public void saveMovieIntoWatchList(@RequestParam("movie_id") Long movieId) {
//        String username = customUserDetailsService.findLoggedInUsername();
//        if (username != null) {
//            Visitor user = allVisitors.findUserByUsername(username);
//            List<Long> watchList = allVisitors.getWatchListByUser(user.getId());
//            watchList.add(movieId);
//            user.setWatchListMovieIds(watchList);
//            allVisitors.save(user);
//        }
//    }

}
