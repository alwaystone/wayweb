------2018年10月18日14:51:55  根据user 和menu表中的基础数据向user_menu中添加数据
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

-----2018年10月18日14:55:05 根据role和menu基础数据向role_menu中添加数据
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

----2018年10月18日15:03:46 查询当前用户所能使用的菜单
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
	
