# Packet Journey — Computer Networking Notes

Interactive, visual study notes for Kunal Kushwaha's **[Computer Networking Full Course – OSI Model Deep Dive with Real Life Examples](https://www.youtube.com/watch?v=IPvYjXCsTg8)** (4 h 7 min).

The whole course is covered chapter by chapter in the video's own order. It's redrawn as diagrams, step-by-step animations and flashcards, so you can revise without rewatching.

---

## Files

| File | What it is |
| --- | --- |
| `Packet-Journey-Networking-Notes.html` | The full interactive version. Open it in any browser; it works offline. |
| `Packet-Journey-Networking-Notes.pdf` | A 48-page printable copy with every section expanded (no interactive parts). |
| `README.md` | This file. |

## How to use

1. Download `Packet-Journey-Networking-Notes.html`.
2. Double-click it to open in Chrome, Edge, Firefox or Safari.
3. Use the chapter list on the left (or the chips at the top on a phone) to jump around.

No install, build step or internet connection is needed. With internet, the page loads its custom fonts (Bricolage Grotesque, IBM Plex Sans, JetBrains Mono); offline it falls back to system fonts.

## Features

- **Packet journey animation**: press Play to follow one message down the 7 OSI layers on your phone, across routers, and back up on your friend's phone. It shows which header is added at each step.
- **OSI layer explorer**: click any layer to see its job, data unit, addressing, protocols, devices and a real-world analogy.
- **About 25 diagrams**: topologies, LAN/MAN/WAN, encapsulation, client–server vs P2P, device-to-layer map, cookies, email flow, DNS resolution, multiplexing, retransmission timers, the TCP 3-way handshake, hop-by-hop routing, NAT, ARP and more.
- **Subnet calculator**: type an address like `192.168.1.0/24` to see its bits split into network and host, plus the mask, address count, range and class.
- **66 interview flashcards**: flip, filter by chapter, shuffle; keyboard shortcuts `←` `→` and `Space`.
- **Revision section**: numbers to memorise, commonly confused pairs, and a 51-topic checklist with a progress bar (saved in your browser only).
- **Interview questions and exam revision** at the end of every chapter.
- **Colour-coded layers**: each OSI layer keeps one colour throughout the page.
- Works on phones and follows your light or dark mode setting.

### Layer colours

| Layer | Colour |
| --- | --- |
| L7 Application | Violet |
| L6 Presentation | Magenta |
| L5 Session | Vermilion |
| L4 Transport | Amber |
| L3 Network | Green |
| L2 Data Link | Blue |
| L1 Physical | Slate |

## Contents

| # | Chapter | Video time |
| --- | --- | --- |
| 01 | How the internet started: ARPANET, protocols, WWW, RFCs | 0:00 – 17:38 |
| 02 | Clients, servers, IP addresses, ports, speeds | 17:38 – 42:25 |
| 03 | Physical internet: submarine cables, LAN/MAN/WAN, modem, router, ISPs, topologies | 42:25 – 1:01:34 |
| 04 | The OSI model, layer by layer | 1:01:34 – 1:29:00 |
| 05 | The TCP/IP model and OSI vs TCP/IP | 1:29:00 |
| 06 | Application layer: architectures, devices, protocols, sockets, HTTP, status codes, cookies | 1:30:20 – 2:11:00 |
| 07 | How email works: SMTP, POP3, IMAP | 2:11:00 |
| 08 | DNS | 2:19:00 |
| 09 | Transport layer: multiplexing, checksum, timers, UDP, TCP, 3-way handshake | 2:32:24 – 3:13:40 |
| 10 | Network layer: routing, control plane, IPv4, subnetting, classes, TTL, IPv6, firewalls, NAT | 3:13:40 – 3:55:40 |
| 11 | Data link and physical: DHCP, ARP, frames, MAC addresses | 3:55:40 – end |
| R1–R5 | Flashcards · key numbers · common confusions · checklist · coverage and corrections | — |

Every chapter heading links to its timestamp in the video.

## How to read the tags

- Plain text is **from the video**.
- **Extra context** boxes add facts the video didn't cover, such as standard port numbers (HTTPS 443, DNS 53) and exact header sizes.
- **Instructor slip** boxes (orange) correct something the video got wrong.

### Corrections included

| Where | Video says | Correct |
| --- | --- | --- |
| Ch 1 | First ARPANET sites included MIT; TCP from the start | UCLA, SRI, UCSB, Utah; NCP first, TCP/IP from 1983 |
| Ch 1 | Yahoo was the first search engine | Archie and ALIWEB came earlier |
| Ch 2 | NAT = network access translator | Network Address Translation |
| Ch 4 | MAC address decides which application | Port picks the app; MAC picks the interface |
| Ch 6 | DHCP "control"; SSH "Secure Socket Shell" | Dynamic Host Configuration Protocol; Secure Shell |
| Ch 9 | Checksum is a random string | Calculated from the data |
| Ch 9 | Server's seq number is derived from the client's; 3rd handshake message has SYN | Each side picks its own random number; the 3rd message is ACK only |
| Ch 10 | Class C subnet mask is 255.255.0.0 | 255.255.255.0 |
| Ch 10 | IETF assigns IP addresses to ISPs | IANA → regional registries (e.g. APNIC) → ISPs |

## How these notes were made

- The video's full auto-generated English transcript (about 1,800 caption segments).
- The official chapter timestamps from the video description.
- Kunal's own course notes: [DevOps-Bootcamp/Networking](https://github.com/kunal-kushwaha/DevOps-Bootcamp/tree/main/Networking), plus the community notes at [rishitxyz/Networking-Course](https://github.com/rishitxyz/Networking-Course).

The video's visuals weren't reviewed frame by frame, so a few details shown only on screen are marked "unable to verify" in the coverage section.

## Credits

All course content belongs to **[Kunal Kushwaha](https://github.com/kunal-kushwaha)**. These are unofficial personal study notes made to support learning from the original video. Please watch and support the [original course](https://www.youtube.com/watch?v=IPvYjXCsTg8).