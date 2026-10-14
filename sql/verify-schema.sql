-- Connect to course_management_session04 before running these read-only queries.
SELECT table_name, column_name, data_type, character_maximum_length,
       is_nullable, is_identity
FROM information_schema.columns
WHERE table_schema = 'public'
  AND table_name IN ('courses', 'instructors', 'students', 'student_enrollments')
ORDER BY table_name, ordinal_position;

SELECT c.relname AS table_name, con.conname AS constraint_name,
       pg_get_constraintdef(con.oid) AS definition
FROM pg_constraint con
JOIN pg_class c ON c.oid = con.conrelid
JOIN pg_namespace n ON n.oid = c.relnamespace
WHERE n.nspname = 'public'
  AND c.relname IN ('courses', 'instructors', 'students', 'student_enrollments')
ORDER BY c.relname, con.conname;

-- Show the source and target columns of each foreign key.
SELECT source.relname AS source_table, col.attname AS foreign_key_column,
       target.relname AS target_table, target_col.attname AS target_column
FROM pg_constraint fk
JOIN pg_class source ON source.oid = fk.conrelid
JOIN pg_namespace ns ON ns.oid = source.relnamespace
JOIN pg_class target ON target.oid = fk.confrelid
JOIN pg_attribute col ON col.attrelid = source.oid AND col.attnum = ANY(fk.conkey)
JOIN pg_attribute target_col ON target_col.attrelid = target.oid AND target_col.attnum = ANY(fk.confkey)
WHERE fk.contype = 'f' AND ns.nspname = 'public'
  AND source.relname IN ('courses', 'student_enrollments')
ORDER BY source_table, foreign_key_column;
