# 📅 SUSU–Schedule

Telegram-бот для удобного просмотра и отслеживания учебного расписания с функциями уведомлений и рассылок.

## ✨ Возможности

- **Просмотр расписания**:
  - На сегодня
  - На завтра
  - На текущую неделю
- **Управление подписками**:
  - Ежедневная рассылка расписания на завтра
  - Уведомления об изменениях в расписании
- **Простой интерфейс чат–бота**

## 🚀 Быстрый старт

### 1. Скачайте [Docker Desktop](https://www.docker.com/get-started/)
### 2. Запустите Docker Desktop
### 3. Установите docker–образ СУБД PostgreSQL 
```bash
docker pull postgres:16
```
### 4. Клонируйте репозиторий
```bash
git clone https://github.com/Evgeniyy2004/SUSU-Schedule.git
cd SUSU-Schedule
```
### 5. Перейдите в Telegram и зарегистрируйте бота в [@BotFather](https://t.me/botfather)
### 6. Сохраните выданный токен в переменную среды *app_telegram_token*
```bash
export app_telegram_token = <Ваш_токен>
```
### 7. Запустите DockerFile в директориях bot и scrapper
```bash
docker build -t scheduleserviceimage:1 scrapper

docker build -t schedulebotimage:1 bot
```
### 8. Запустите compose.yml для запуска приложения
```bash
docker compose up -d
```
### 9. Перейдите в созданного чат-бота Telegram и отправьте */start* для начала работы
