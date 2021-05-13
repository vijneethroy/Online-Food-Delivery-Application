package com.cg.fooddelivery.repository;

import com.cg.fooddelivery.entities.Login;

public interface ILoginRepository {
	
	public Login signIn(Login login);
	public Login signOut(Login login);
}
