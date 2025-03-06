SET search_path TO public;

CREATE TABLE roles (
  id     VARCHAR(255) NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id)
);

CREATE TABLE permissions_view (
	id     VARCHAR(255) NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	CONSTRAINT permissions_view_pkey PRIMARY KEY (id)
);

CREATE TABLE permissions_api (
	id     VARCHAR(255) NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	CONSTRAINT permissions_api_pkey PRIMARY KEY (id)
);

CREATE TABLE permissions (
	api_id  VARCHAR(255) NOT NULL,
	role_id VARCHAR(255) NOT NULL,
	view_id VARCHAR(255) NOT NULL,
	CONSTRAINT permissions_pkey   PRIMARY KEY (api_id, role_id, view_id),
	CONSTRAINT fk_permission_api  FOREIGN KEY (api_id)                    REFERENCES permissions_api(id),
	CONSTRAINT fk_permission_role FOREIGN KEY (role_id)                   REFERENCES roles(id),
	CONSTRAINT fk_permission_view FOREIGN KEY (view_id)                   REFERENCES permissions_view(id)
);

CREATE INDEX idx_api_id  ON permissions USING btree (api_id);
CREATE INDEX idx_role_id ON permissions USING btree (role_id);
CREATE INDEX idx_view_id ON permissions USING btree (view_id);