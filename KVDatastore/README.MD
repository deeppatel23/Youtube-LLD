💡 Problem Title:
Design a Pluggable and Extensible In-Memory Key-Value Store

🎯 Objective:
Design a modular Key-Value Store system that supports multiple storage engines (like an in-memory HashMap or Redis) and allows runtime addition of extra features such as logging and time-to-live (TTL) for keys, without modifying the core logic of the system.

🧩 Functional Requirements:
Basic Key-Value Operations

put(String key, String value)

String get(String key)

void delete(String key)

Pluggable Storage Backends

Support for multiple key-value store backends:

InMemoryStore: uses Java’s HashMap

RedisKVStore: mocks a Redis-like storage system

Runtime Feature Extensions (Decorators)

LoggingDecorator: Logs every operation (GET, PUT, DELETE)