package de.hska.financepal.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import de.hska.financepal.entity.Portfolio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PortfolioViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PortfolioRepository

    val portfolios: LiveData<List<Portfolio>>

    init {
        val portfolioDao = AppDatabase.getDatabase(application).portfolioDAO()
        repository = PortfolioRepository(portfolioDao)
        portfolios = repository.getPortfolios()
    }

    fun insert(portfolio: Portfolio) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertPortfolio(portfolio)
    }
}