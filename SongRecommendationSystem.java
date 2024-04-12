package LeetCode;

import java.util.*;

public class SongRecommendationSystem {
    public static class Song {
        String title;
        
        public Song(String title) {
            this.title = title;
        }
        
        public String getTitle() {
            return this.title;
        }
    }
    
    public static class User {
        String userName;
        List<Song> favSongs;
        
        public User(String userName) {
            this.userName = userName;
            this.favSongs = new ArrayList<Song>();
        }
        
        public void addSong(Song song) {
            this.favSongs.add(song);
        }
        
        public List<Song> getFavSongs() {
            return favSongs;
        }
    }
    
    public static class RecommendationSystem {
        List<User> users;
        
        public RecommendationSystem() {
            this.users = new ArrayList<User>();
        }
        
        public void addUser(User user) {
            this.users.add(user);
        }
        
        public List<Song> recommendSong(Set<Song> likeSongs) {
            Map<Song, Integer> songScoresMap = new HashMap<Song, Integer>();
            
            for (User user : this.users) {
                for (Song song : user.favSongs) {
                    if (!songScoresMap.containsKey(song)) {
                        songScoresMap.put(song, songScoresMap.getOrDefault(song, 0) + 1);
                    }
                }
            }
            
            // Sort songs by their score (number of users who liked them)
            List<Map.Entry<Song, Integer>> sortedSongs = new ArrayList<>(songScoresMap.entrySet());
            Collections.sort(sortedSongs, (a, b) -> b.getValue().compareTo(a.getValue()));
            
            // Extract recommended songs from the sorted list
            List<Song> recommendedSongs = new ArrayList<>();
            for (Map.Entry<Song, Integer> entry : sortedSongs) {
                recommendedSongs.add(entry.getKey());
            }
            
            return recommendedSongs;
        }
    }
    
    public static List<String> recommendSong(List<List<String>> usersFavSongs, List<String> favSongs) {
        Map<String, List<Integer>> songFavedByUserMap = new HashMap<>();
        // key: song
        // val: list of users who fav this song
        Map<String, Integer> songRecommendationScoreMap = new HashMap<>();
        // key: favSong
        // val: recommendation score based on similar user
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < usersFavSongs.size(); i++) {
            List<String> userFavSongs = usersFavSongs.get(i);
            for (String song : userFavSongs) {
                if (songFavedByUserMap.containsKey(song)) {
                    songFavedByUserMap.get(song).add(i + 1);
                } else {
                    List<Integer> users = new ArrayList<>();
                    users.add(i + 1);
                    songFavedByUserMap.put(song, users);
                }
            }
        }
        
        for (String favSong : favSongs) {
            List<Integer> similarUsers = songFavedByUserMap.getOrDefault(favSong, new ArrayList<>());
            // similarUsers: all users that fav-ed current song
            for (int user : similarUsers) {
                for (String song : usersFavSongs.get(user - 1)) {
                    if (!song.equals(favSong)) {
                        songRecommendationScoreMap.put(song, songRecommendationScoreMap.getOrDefault(song, 0) + 1);
                    }
                }
            }
        }
        
        List<Map.Entry<String, Integer>> sortedSongRecommendationScoreMap = new ArrayList<>(songRecommendationScoreMap.entrySet());
        sortedSongRecommendationScoreMap.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int maxRecommendationScore = (sortedSongRecommendationScoreMap.size() > 0) ? sortedSongRecommendationScoreMap.get(0).getValue() : 0;
        
        for (Map.Entry<String, Integer> entry : sortedSongRecommendationScoreMap) {
            if (entry.getValue() == maxRecommendationScore) {
                result.add(entry.getKey());
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<String> user1 = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        List<String> user2 = new ArrayList<>(Arrays.asList("A", "C", "D"));
        List<String> user3 = new ArrayList<>(Arrays.asList("B", "C", "E"));
        List<String> user4 = new ArrayList<>(Arrays.asList("B", "C", "D"));
        
        List<List<String>> users = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
        List<String> favSongs = new ArrayList<>(Arrays.asList("C", "D"));
        Print.printStringList(recommendSong(users, favSongs));
    }
//    public static void main(String[] args) {
//        // Create songs
//        Song songA = new Song("A");
//        Song songB = new Song("B");
//        Song songC = new Song("C");
//        Song songD = new Song("D");
//        Song songE = new Song("E");
//
//        // Create users and their liked songs
//        User user1 = new User("User 1");
//        user1.addSong(songA);
//        user1.addSong(songB);
//        user1.addSong(songC);
//        user1.addSong(songD);
//
//        User user2 = new User("User 2");
//        user2.addSong(songA);
//        user2.addSong(songC);
//        user2.addSong(songD);
//
//        User user3 = new User("User 3");
//        user3.addSong(songB);
//        user3.addSong(songC);
//        user3.addSong(songE);
//
//        // Create recommendation system and add users
//        RecommendationSystem recommendationSystem = new RecommendationSystem();
//        recommendationSystem.addUser(user1);
//        recommendationSystem.addUser(user2);
//        recommendationSystem.addUser(user3);
//
//        // User with liked songs C and D
//        Set<Song> likedSongs = new HashSet<>();
//        likedSongs.add(songC);
//        likedSongs.add(songD);
//
//        // Recommend songs for the user
//        List<Song> recommendedSongs = recommendationSystem.recommendSong(likedSongs);
//
//        // Display recommended songs
//        System.out.println("Recommended Songs:");
//        for (Song song : recommendedSongs) {
//            System.out.println(song.getTitle());
//        }
//    }
}
/**
 * Question:
 * the historical data
 * User 1 has liked A, B, C, D
 * User 2 has liked A, C, D
 * User 3 has liked B, C, E
 * <p>
 * Now we have a user that liked C, D
 * As user1 and user 2 both like C and D, so their liked song will be recommend.
 * The system should recommend the user song A, B
 * ( A should appear first, as user1 and user2 both liked A)
 */