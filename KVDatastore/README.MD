# Key-Value Store

A flexible and extensible key-value store system implemented in Java, supporting multiple storage backends and optional runtime enhancements such as TTL and logging.

---

## 🧩 Core Operations (MVP)

The key-value store supports the following core operations:

- `set(key, value)` – Store a key-value pair.
- `get(key)` – Retrieve the value associated with a key.
- `delete(key)` – Remove a key and its associated value.

These operations should function with any datastore implementation (e.g., in-memory, Redis-like stub).

---

## 🗃️ Multiple Storage Backends

Your system should support at least **two** storage backends:

### 1. SimpleKVStore (In-Memory)
- Backed by a Java `HashMap`.

### 2. RedisKVStore (Mock)
- Simulates Redis using a stub or mock class.
- Does **not** connect to a real Redis server.

---

## ⚙️ Functional Enhancements

### ⏱️ TTL (Time-To-Live) Support
- Optionally store a key with a TTL value in **milliseconds**.
- Keys should automatically expire after the specified TTL.
- TTL should not be baked into every store — must be optional.
- Default TTL: `100000 milliseconds` (100 seconds).
- During a `get()`, if a key is expired, it should be removed from the datastore.

### 📜 Logging Support
- Optionally log every `set`, `get`, and `delete` operation.
- This feature should be dynamically attachable and not embedded into every store.

---

## ✅ Expectations

- Use **interface-driven design** to promote flexibility.
- Follow **SOLID principles** and established **design patterns**.
- Include **working code** with a driver class demonstrating functionality.
- Allow users to **configure optional functionalities** like TTL and logging at runtime.
