
allup:
	docker compose --profile observability up -d
up:
	docker compose up -d

infra/down:
	docker compose down
