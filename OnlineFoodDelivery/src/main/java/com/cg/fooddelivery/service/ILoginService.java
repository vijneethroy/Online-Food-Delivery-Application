package com.cg.fooddelivery.service;

import com.cg.fooddelivery.entities.Login;

public interface ILoginService {
	
	public Login signIn(Login login);
	public Login signOut(Login login);
}
