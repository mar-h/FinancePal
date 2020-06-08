package de.hska.financepal.db

import de.hska.financepal.entity.Portfolio

class PortfolioRepository(private val portfolioDAO: PortfolioDAO) {
    /*
    * Repository für Portfolio-Datenoperationen
    */
    fun getPortfolios() = portfolioDAO.getPortfolios()
    fun getPortfolioByBesitzer(userId: Int) = portfolioDAO.getPortfolioByBesitzer(userId)
    fun getPortfolioById(id: Int) = portfolioDAO.getPortfolioById(id)
    suspend fun insertPortfolio(portfolio: Portfolio) {
        portfolioDAO.insertPortfolio(portfolio)
    }}