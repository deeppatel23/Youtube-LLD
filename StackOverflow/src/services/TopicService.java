package services;

import models.Topic;

public class TopicService {
    static Topic getOrCreateTopic(String name) {
        name = name.toLowerCase();
        if (!Database.topics.containsKey(name)) {
            Database.topics.put(name, new Topic(name));
        }
        return Database.topics.get(name);
    }
}
