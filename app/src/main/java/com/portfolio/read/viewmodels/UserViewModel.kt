package com.portfolio.read.viewmodels

import androidx.lifecycle.ViewModel
import com.portfolio.read.models.User

class UserViewModel : ViewModel() {
    // Dummy user data
    val user = User("John Doe", "john@example.com")
}
