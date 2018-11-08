------2018��10��18��14:51:55  ����user ��menu���еĻ���������user_menu���������
INSERT INTO user_menu(id, user_id, menu_id)(
	SELECT
		REPLACE(UUID(), "-", ""),
		u.user_id,
		m.menu_id
	FROM
		menu m,
		USER u
	WHERE
		u.user_id = 'user1'
)

-----2018��10��18��14:55:05 ����role��menu����������role_menu���������
INSERT INTO role_menu(id, role_id, menu_id)(
	SELECT
		REPLACE(UUID(), "-", ""),
		r.role_id,
		m.menu_id
	FROM
		menu m,
		role r
	WHERE
		r.role_id = 'role1'
)

----2018��10��18��15:03:46 ��ѯ��ǰ�û�����ʹ�õĲ˵�
SELECT
	m.menu_name,
	m.`level`,
	m.url,
	m.menu_id,
	m.parent_id
FROM
	role_menu r
LEFT JOIN menu m ON r.menu_id = m.menu_id
WHERE
	r.role_id = 'role1'
UNION
	SELECT
		um.menu_name,
		um.`level`,
		um.url,
		um.menu_id,
		um.parent_id
	FROM
		user_menu u
	LEFT JOIN menu um ON u.menu_id = um.menu_id
WHERE
	u.user_id = 'user1'
	
