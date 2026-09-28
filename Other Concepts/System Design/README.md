# System Design Blueprint

Master study notes for system design. Two full video courses are merged into one interactive page, organised for both learning and quick revision.

| Course | Teacher | Length |
| --- | --- | --- |
| [System Design One Shot Full Course](https://www.youtube.com/watch?v=Vnm-ycSfJx4) | Telusko | 5 h 5 min |
| [System Design for Beginners (2026)](https://www.youtube.com/watch?v=SE2KF-vxvS0) | KodeKloud | 1 h 25 min |

Where both courses cover the same topic, the notes combine them in one chapter. Small **T** (Telusko) and **K** (KodeKloud) tags show which course said what.

---

## How to use

1. Download `System-Design-Master-Notes.html`.
2. Double-click it to open it in Chrome, Edge, Firefox or Safari.

That's it: no install and no build step, and it works offline. With internet, the page loads its custom fonts; offline it uses your system fonts.

It works on phones and follows your light or dark mode setting.

## Study and revision features

| Feature | What it does |
| --- | --- |
| **Study / Revise switch** | Top bar. Revise mode collapses every chapter to its "Remember" summary, so the whole course reads in about 30 minutes. |
| **Search** | Top bar (press `/`). Shows only the chapters that mention your word. |
| **Mark learned** | A button on every chapter. The side menu shows ✓ marks and the top bar counts your progress (e.g. 7/25). |
| **Remember boxes** | 2–5 key points at the start of each chapter, with an estimated revision time. |
| **Graded flashcards** | 98 cards. Flip, then grade yourself **Still learning** or **Know it**; missed cards collect in a **Review pile**. Keys: `Space` flip · `←` `→` move · `1` still learning · `2` know it. |
| **Interview playbook** | Nine steps in the order to speak during a system design interview, each linked to its chapter. |
| **Interview questions** | Collapsible Q&A at the end of every chapter. |
| **Timestamps** | Every chapter links to the exact moment in each video. |

Your ticks, flashcard grades and chosen mode are saved in your browser only. Another browser or device starts fresh.

## Interactive diagrams and simulators

- **Photo app builder**: grow a photo-sharing app from one $10 server to load balancer, sessions, storage, indexes, cache, replicas and shards, one failure at a time.
- **Alien Bank story**: one cash counter becoming a system (faster code → vertical scaling → horizontal scaling → shared database → load balancer).
- **Cache strategies**: switch between read-through, write-through, write-around and write-back and watch the data flow change.
- **Cache eviction**: a 3-slot cache showing what LRU, MRU, LFU, FIFO and LIFO remove.
- **Load balancing**: send requests with round robin, weighted, geo-based, least connections, least time or IP hash.
- **Quorum calculator**: check whether reads and writes overlap (`w + r > n`).
- **CAP picker**: choose two of C, A, P and see what you give up.
- **Latency percentiles**: edit response times and compare average, P50, P90 and P99.
- **Sharding calculator**: see why `id % shards` moves most data when you add a shard, and how consistent hashing avoids it.

## Colours

Each module keeps one colour throughout the page.

| Module | Colour |
| --- | --- |
| Foundations | Violet |
| Communication | Blue |
| Data & storage | Green |
| Scale & distribution | Amber |
| Reliability & ops | Vermilion |
| Case studies | Magenta |

## Contents

| # | Chapter | Source |
| --- | --- | --- |
| **Foundations** | | |
| 01 | What is system design (the $10 server, Alien Bank) | T + K |
| 02 | HLD vs LLD | K |
| 03 | Requirements and the 5 questions to ask | T + K |
| 04 | Data-intensive vs compute-intensive | T |
| 05 | The building blocks | T |
| 06 | Monolith vs microservices | K |
| 07 | Vertical vs horizontal scaling | K + T |
| **Communication** | | |
| 08 | How a request travels, and DNS | K + T |
| 09 | APIs and API styles (REST, SOAP, GraphQL, gRPC, WebSockets) | T |
| 10 | REST in depth | T |
| **Data & storage** | | |
| 11 | Data modeling and access patterns | K |
| 12 | SQL databases | T + K |
| 13 | NoSQL and choosing a database | T + K |
| 14 | Database indexes | K |
| 15 | Caching | T + K |
| **Scale & distribution** | | |
| 16 | Load balancers | K + T |
| 17 | Stateless vs stateful | K |
| 18 | Replication | K + T |
| 19 | Sharding (partitioning) | K + T |
| 20 | CAP theorem | T |
| **Reliability & ops** | | |
| 21 | Message queues and pub-sub | T |
| 22 | Faults | T |
| 23 | Monitoring | T |
| **Case studies** | | |
| 24 | Photo-sharing app | K |
| 25 | Video streaming | T |
| **Revision** | | |
| R1 | Interview playbook | |
| R2 | Flashcards | |
| R3 | Key numbers | |
| R4 | Common confusions | |
| R5 | Corrections and coverage | |

## How to read the tags

- Plain text is **from the videos**.
- **Extra context** boxes add facts neither video covered.
- **Instructor slip** boxes (orange) correct something a video got wrong.

### Corrections included

| Ch | Video says | Correct |
| --- | --- | --- |
| 4 (T) | WhatsApp: 2–10 million messages/day | Roughly 100 billion/day |
| 8 (T) | 13 (or 30) companies own the root servers | 13 identities, 12 operators, 1,000+ instances |
| 10 (T) | 401 when not allowed to delete | 403 if logged in but not permitted |
| 13 (K) | Structured → SQL, unstructured → NoSQL, as the only question | Good rule of thumb; access patterns, consistency and scale also matter |
| 15 (T) | Write-around = read-through + write-through | Write-around skips the cache on writes |
| 16 (T) | Least connections for sticky sessions; weighted RR sends to the heaviest | Least connections suits long-lived connections; weighted RR sends a proportional share |
| 18 (T) | Quorum = more than n/2 each | General rule `w + r > n` |
| 19 (K) | Consistent hashing: each shard owns a range of user IDs | It owns a range of hash values on a ring |
| 20 (T) | CAP is about "capacity"; P = data partitions | Consistency; P = network partition |
| 25 (T) | RTMP and RTSP stream the video | Playback today is mostly HLS/DASH over HTTP |

## How these notes were made

- The full auto-generated English transcripts of both videos (Telusko: 2,324 caption lines; KodeKloud: 4,091).
- Both videos' official chapter timestamps.

The videos' visuals weren't reviewed frame by frame. Details shown only on screen are marked as unverified in the Corrections and coverage section.

## Credits

All course content belongs to **[Telusko](https://www.youtube.com/@Telusko)** and **[KodeKloud](https://www.youtube.com/@KodeKloud)**. These are unofficial personal study notes. Please watch and support the original courses:

- [Telusko: System Design One Shot Full Course](https://www.youtube.com/watch?v=Vnm-ycSfJx4) · [Telusko system design notes](https://docs.telusko.com/docs/system-design/getting-started)
- [KodeKloud: System Design for Beginners (2026)](https://www.youtube.com/watch?v=SE2KF-vxvS0) · [KodeKloud free labs](https://kode.wiki/4fpJtkE)