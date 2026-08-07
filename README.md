# Inventory Management System

Spring Bootを使用して作成した備品管理システムです。
備品情報の登録・編集・削除・一覧表示を行うCRUD機能を実装し、Spring Bootを用いたWebアプリケーション開発を学習することを目的に作成しました。

## 使用技術

- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- H2 Database
- Maven

## 主な機能

- 備品の登録
- 備品一覧表示
- 備品情報の編集
- 備品情報の削除
- 商品名による検索
- 在庫数が少ない備品の検索
- 価格順での並び替え
- 入力チェック（バリデーション）
- エラーメッセージの表示

## 学習内容

- Spring BootによるWebアプリケーション開発
- Spring Data JPAを使用したデータベース操作
- Thymeleafを使用した画面作成
- CRUD（登録・一覧表示・更新・削除）機能の実装
- Controller、Service、Repositoryに役割を分けた設計
- Spring Data JPAを利用した検索・並び替え機能の実装
- 入力チェック
- バリデーションエラー時の画面表示
- 登録完了メッセージの表示
- 削除前の確認ダイアログ

## 工夫した点

- Repositoryのメソッド名を利用した商品名検索・在庫検索を実装
- Sortクラスを利用して価格順ソートを実装
- 入力チェックとエラーメッセージ表示により、入力ミスを防止

## 画面イメージ

### メイン画面
登録・検索・並び替え機能
<img width="964" height="509" alt="main-page" src="https://github.com/user-attachments/assets/c512c6ec-60e8-4f6e-a525-990bb93f6886" />

### 備品一覧画面
登録した備品を一覧表示し、編集・削除を行えます。
<img width="944" height="567" alt="item-list" src="https://github.com/user-attachments/assets/98804a82-b0bd-4aca-9c07-92d5fe0d7f9e" />




