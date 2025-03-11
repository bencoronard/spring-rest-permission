SET search_path TO public;

CREATE TABLE roles (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    CONSTRAINT uq_roles_name UNIQUE (name) -- Unique constraint for role name
);

CREATE TABLE api_accesses (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "path" VARCHAR(255) NOT NULL,
    "token" VARCHAR(255) NOT NULL,
    CONSTRAINT uq_api_accesses_path UNIQUE (path), -- Unique constraint for API path
    CONSTRAINT uq_api_accesses_token UNIQUE (token) -- Unique constraint for API token
);

CREATE TABLE view_accesses (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "path" VARCHAR(255) NOT NULL,
    "token" VARCHAR(255) NOT NULL,
    CONSTRAINT uq_view_accesses_path UNIQUE (path), -- Unique constraint for View path
    CONSTRAINT uq_view_accesses_token UNIQUE (token) -- Unique constraint for View token
);

CREATE TABLE role_api_links (
    api_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    CONSTRAINT pk_role_api_links PRIMARY KEY (api_id, role_id), -- Composite PK
    CONSTRAINT fk_role_api_links_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE,
    CONSTRAINT fk_role_api_links_api FOREIGN KEY (api_id) REFERENCES api_accesses(id) ON DELETE CASCADE
);

CREATE TABLE role_view_links (
    role_id BIGINT NOT NULL,
    view_id BIGINT NOT NULL,
    CONSTRAINT pk_role_view_links PRIMARY KEY (role_id, view_id), -- Composite PK
    CONSTRAINT fk_role_view_links_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE,
    CONSTRAINT fk_role_view_links_view FOREIGN KEY (view_id) REFERENCES view_accesses(id) ON DELETE CASCADE
);

CREATE TABLE view_api_links (
    api_id BIGINT NOT NULL,
    view_id BIGINT NOT NULL,
    CONSTRAINT pk_view_api_links PRIMARY KEY (api_id, view_id), -- Composite PK
    CONSTRAINT fk_view_api_links_api FOREIGN KEY (api_id) REFERENCES api_accesses(id) ON DELETE CASCADE,
    CONSTRAINT fk_view_api_links_view FOREIGN KEY (view_id) REFERENCES view_accesses(id) ON DELETE CASCADE
);
