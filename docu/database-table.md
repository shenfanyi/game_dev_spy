# Table Schema

## User

| Field Name   | Field Type    |
| ------------ | ------------- |
| user_id      | string        |
| nickname     | string        |
| level        | int8          |
| words_played | Array<string> |

## Room

| Field Name   | Field Type    |
| ------------ | ------------- |
| room_id      | string        |
| match_id     | string        |
| occupied     | boolean       |

## Word

| Field Name   | Fiedl Type    |
| ------------ | ------------- |
| word_id      | string        |
| c_word       | string        |
| s_word       | string        |
| vote_up      | long          |
| vote_down    | long          |

## Match

| Field Name   | Field Type    |
| ------------ | ------------- |
| match_id     | string        |
| room_id      | string        |
| judege       | string        |
| player       | Array<string> |
| rounds       | Array<string> |
| current_round| int           |

## Round

| Field Name   | Field Type        |
| ------------ | ----------------- |
| round_id     | string            |
| match_id     | string            |
| word_id      | string            |
| players      | Array<Object>     | 
| voting_log   | Array<Array<int>> |
| latest_msg   | string            |


- players: 
    ``[index: { user_id: "", status: ""/* dead, living, talking */ }]``

- votinh_log:
    ``[ index/* voting times */: [ index/* user number */: /* votes count */ ] ]``


