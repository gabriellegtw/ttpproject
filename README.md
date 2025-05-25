# Proposed tech stacks

Frontend: React.js
Backend: Spring Boot
Database: PostgreSQL

# Problem Statement 

Develop an interactive learning tool specifically designed to empower women in tech by
allowing them to curate their own learning paths based on their individual circumstances.
The tool will provide users with hands-on learning experiences to accelerate their learning.

# Features

– Profile Creation: Users can create detailed profiles including their career stage, current
skills, goals, and available time for learning.

– Adaptive learning: This tool aims to generate a personalised learning path for
each user and adjust the content as students progress through their learning.

– Progress Tracking: Tracks the users progress with learning badges and experience levels

– Performance Analysis: Comprehensive tracking and analysis of user performance to
identify strengths and areas for improvement.

# Use Cases

(For all use cases, the System is the application and the Actor is the user, unless stated otherwise)

Use Case: UC1 - Signing in

Main Success Scenario (MSS):
1. User enters username and password into sign in page
2. System brings user to their account page

Use case ends.

Extensions:

- 1a. User does not have an existing account

  - 1a1. System brings user to sign up page

  - 1a2. User creates an account
  
    Use case resumes from step 2.

- 1b. User keys in the wrong password

    - 1b1. System prompts user that password is incorrect

      Use case resumes from step 1.

Use Case: UC2 - Signing up (Creating an account)

MSS:

1. User enters username and password into sign in page
2. User enters password again to confirm password
3. System brings user to their account page

Use case ends.

Extensions:

- 1a. User keys in a weak password

    - 1a1. System prompts user to type in a stronger password

      Use case resumes from step 1.

- 2a. User keys in a password that differs from the original

    - 2a1. System prompts user that password is incorrect

      Use case resumes from step 2.

Use Case: UC3 - Creating a profile 

MSS:

1. In profile page, user can key in their career stage, current skills, goals, and available time for learning.
2. User saves their profile

Use case ends.

Extensions:

- 1a. User keys in a weak password

    - 1a1. System prompts user to type in a stronger password

      Use case resumes from step 1.

- 2a. User keys in a password that differs from the original password

    - 2a1. System prompts the user that their password is incorrect

      Use case resumes from step 2.

Use Case: UC4 - Generating a learning path

MSS:

1. After UC3, user is shown a page containing their personalised learning plan
2. User confirms the learning plan

Use case ends.

Extensions:

- 1a. User wants to edit parts of the plan

    - 1a1. Using the UI, the user makes edits accordingly

      Use case resumes from step 1.

Use Case: UC5 - Progress / Performance Analysis

MSS:

1. User navigates to `Progress` tab
2. User is able to view their strengths and weaknesses
(i.e what they have completed and what they seem to struggle completing) 

Use case ends.

Use Case: (Nice to have) UC6 - Regeneration of learning plan

MSS:

1. User navigates to `Profile` tab
2. User is able to edit their goals accordingly
3. System regenerates a learning path for them based on their path so far and new goals

Use case ends.

# Implementation

Note: For now, I have included only features that I think are the most necessary.
I would add more features if time permits!

## Overall structure 

I plan to use the Model-View-Controller (MVC) design pattern, where the `View` aspect is done using React.js
and the `Model` and `Controller` aspect is handled using Spring Boot.

## Features 

### `Profile` tab
This would be a typical profile creation tab with the following fields: career stage, current
skills, goals, and available time for learning. Users would be able to type in their details and they will be
stored as Strings

### `Learning plan` tab
Initially, I was planning to use 

### `Progress` tab
Tracks the users progress with learning badges and experience levels. 
This tab also has a short performance analysis at the top. For instance, if the user 
struggles with a certain kind of task (e.g. keeping up with a coursera course), this weakness
would be reflected at the top

## UML diagram

