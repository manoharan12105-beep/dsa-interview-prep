# Linux Master Notes

Complete, interactive English study notes for Linux and Bash scripting. They merge two video courses into one set of notes and add extra context where the courses stop short.

## Sources

| Tag | Course | Length |
|---|---|---|
| **T** | [Linux Masterclass in Tamil, 2025 Edition](https://www.youtube.com/watch?v=RsTeDuC6xHY) by Data Engineering Tamil (Gowtham) | 4 h 10 min |
| **B** | [Bash Scripting Tutorial for Beginners](https://www.youtube.com/watch?v=tK9Oc6AEnR4) by freeCodeCamp (Herbert Lindemans) | 48 min |
| **+** | Extra context added by these notes | |

The Tamil course is translated into English throughout.

## How to use

1. Open `Linux-Master-Notes.html` in any modern browser (Chrome, Edge, Firefox, Safari).
2. It is a single file and works offline. Only the fonts load from the internet, and it falls back to system fonts without them.
3. Your progress, reading mode and flashcard grades are saved in that browser only.

## Features

| Feature | What it does |
|---|---|
| **Study / Revise** switch | Revise collapses every chapter into its "Remember" box and interview questions. |
| **Search** (press `/`) | Filters chapters to those mentioning a word. |
| **Mark learned** | Per-chapter tick with a progress bar in the top bar. |
| **Source links** | ▶ T / ▶ B chips jump to the exact moment in the video. |
| **Interview & exam questions** | Collapsible Q&A at the end of every chapter. |
| **Cheat sheet** | 110 commands, filterable by text or module. |
| **Flashcards** | 92 cards with Still learning / Know it grading and a review pile. Keyboard: Space, ←, →, 1, 2. |
| **Dark mode** | Follows your system setting. |

### Simulators

- **A day on a Linux server**: a 12-step terminal walkthrough, from `ssh` to `crontab` to `scp`.
- **Practice shell** (Ch 7): a safe fake filesystem with `cd`, `ls`, `mkdir -p`, `touch`, `echo >>`, `mv` and `rm`, plus Tab completion and ↑ history.
- **Hard vs soft links** (Ch 9): create links, delete the original and watch what breaks.
- **Pipeline builder** (Ch 11): grep → sort → head → wc on an editable sample log.
- **awk field splitter** (Ch 14)
- **chmod calculator** (Ch 16): checkboxes ↔ octal ↔ `rwx` string.
- **What survives what** (Ch 17): foreground vs `&` vs `nohup` vs cron against Ctrl+C, closing the terminal, Wi-Fi loss, `kill -9` and a reboot.
- **test / `$?` evaluator** (Ch 24)
- **Cron builder** (Ch 27): shows the schedule in plain English and the next five run times.

## Contents

| Module | Chapters |
|---|---|
| 1 · Foundations | 1 Why Linux & open source · 2 Kernel, OS & distros · 3 Setup: WSL, shell & filesystem |
| 2 · Everyday commands | 4 First commands · 5 vi, vim, nano · 6 Working with files · 7 ls, cd, mkdir · 8 Environment variables & alias · 9 Hard & soft links |
| 3 · Text processing | 10 Pipes & redirection · 11 wc, sort, head, tail · 12 grep · 13 find · 14 awk · 15 sed |
| 4 · System & processes | 16 Permissions & chmod · 17 Processes, nohup, ps, top, kill · 18 Disk, memory, zip, tar · 19 apt & wget |
| 5 · Remote access | 20 SSH & PuTTY · 21 scp & WinSCP |
| 6 · Bash scripting | 22 First script · 23 Variables, input, arguments, exit codes · 24 test, if, case · 25 Arrays & loops · 26 Functions |
| 7 · Automation | 27 cron · 28 Airflow on WSL (MySQL → CSV ETL every 5 minutes) |
| Revision | R1 Cheat sheet · R2 Flashcards · R3 Tables & numbers · R4 Common confusions · R5 Corrections & coverage |

## How to read the tags

- **T / B**: which course said it.
- **Dashed "Extra context" boxes and + rows**: added by these notes, not in either video.
- **Orange "Instructor slip" boxes**: something a video got wrong, with the correction.

## How the notes were made

- The Tamil course's full auto-generated captions were read in both Tamil and English machine translation. The Bash course's full English captions were also read.
- All 24 + 15 chapter timestamps are mapped to chapters in R5.
- Code shown only on screen, such as the ETL script and DAG details, was reconstructed from the narration.
- Terminal outputs are representative, so your exact output will differ.

## Credits

All teaching content belongs to **Data Engineering Tamil (Gowtham)** and **freeCodeCamp / Herbert Lindemans**. The Bash course code is at [herbertech/bash-intro-tutorial](https://github.com/herbertech/bash-intro-tutorial). These are personal study notes, not affiliated with either channel.