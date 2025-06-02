package services;

import models.Answer;
import models.Question;
import models.Topic;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class Database {
    static Map<String, User> users = new HashMap<>();
    static Map<String, Topic> topics = new HashMap<>();
    static Map<Integer, Question> questions = new HashMap<>();
    static User currentUser = null;
}
