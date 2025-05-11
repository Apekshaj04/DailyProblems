SELECT user_id,
       email
  FROM users
 WHERE regexp_like(email, '^[[:alnum:]_]+@[[:alpha:]]+\.com$')
 ORDER BY user_id;
