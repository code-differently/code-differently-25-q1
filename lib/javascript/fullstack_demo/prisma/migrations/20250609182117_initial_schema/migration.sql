-- CreateTable
CREATE TABLE "Todos" (
    "id" BIGSERIAL NOT NULL,
    "user_id" VARCHAR NOT NULL,
    "text" VARCHAR NOT NULL DEFAULT '',
    "completed" BOOLEAN NOT NULL DEFAULT false,
    "created_at" TIMESTAMPTZ(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT "Todos_pkey" PRIMARY KEY ("id")
);

-- CreateTable
CREATE TABLE "Logs" (
    "id" UUID NOT NULL DEFAULT gen_random_uuid(),
    "level" VARCHAR NOT NULL,
    "message" VARCHAR NOT NULL DEFAULT '',
    "timestamp" TIMESTAMP(6) NOT NULL,
    "meta" JSONB,

    CONSTRAINT "Logs_pkey" PRIMARY KEY ("id")
);
