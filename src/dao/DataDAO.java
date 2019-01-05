package dao;

import dataaccsesshelper.DataAccsessHelper;

public abstract class DataDAO extends DataAccsessHelper {
	public abstract void getAll();

	public abstract void getInsert();

	public abstract void getUpdate();

	public abstract void getDelete();

	public abstract Object find();
}
