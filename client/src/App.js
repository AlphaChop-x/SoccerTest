import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import PlayersListPage from './pages/PlayersListPage';
import AddPlayerPage from './pages/AddPlayerPage';
import EditPlayerPage from './pages/EditPlayerPage';

function App() {
    return (
        <Router>
            <nav style={{ marginBottom: '20px' }}>
                <Link to="/players">Список игроков</Link> |{" "}
                <Link to="/add-player">Добавить игрока</Link>
            </nav>

            <Routes>
                <Route path="/" element={<PlayersListPage />} />
                <Route path="/players" element={<PlayersListPage />} />
                <Route path="/add-player" element={<AddPlayerPage />} />
                <Route path="/players/:id/edit" element={<EditPlayerPage />} />
            </Routes>
        </Router>
    );
}

export default App;
