import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../services/api';

const AddPlayerPage = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        firstName: '',
        sureName: '',
        gender: 'MALE',
        dateOfBirth: '',
        teamName: '',
        state: 'RUSSIA',
    });
    const [teams, setTeams] = useState([]);
    const [newTeam, setNewTeam] = useState('');
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        const fetchTeams = async () => {
            try {
                const response = await api.get('/api/teams');
                setTeams(response.data);
            } catch (err) {
                setError('Ошибка загрузки команд');
            }
        };
        fetchTeams();
    }, []);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        setLoading(true);
        try {
            let teamNameToUse = formData.teamName;

            if (newTeam.trim()) {
                await api.post('/api/teams', { teamName: newTeam });
                setTeams([...teams, { teamName: newTeam }]);
                teamNameToUse = newTeam;
                setNewTeam('');
            }

            await api.post('/api/players', { ...formData, teamName: teamNameToUse });
            alert('Футболист добавлен!');
            navigate('/players');
        } catch (err) {
            setError(err.response?.data?.message || 'Ошибка при добавлении футболиста');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div>
            <h2>Добавить футболиста</h2>
            {error && <div style={{ color: 'red' }}>{error}</div>}
            <form onSubmit={handleSubmit}>
                <input
                    placeholder="Имя"
                    value={formData.firstName}
                    onChange={(e) => setFormData({ ...formData, firstName: e.target.value })}
                    required
                />
                <input
                    placeholder="Фамилия"
                    value={formData.sureName}
                    onChange={(e) => setFormData({ ...formData, sureName: e.target.value })}
                    required
                />
                <select
                    value={formData.gender}
                    onChange={(e) => setFormData({ ...formData, gender: e.target.value })}
                    required
                >
                    <option value="">Пол</option>
                    <option value="MALE">Мужской</option>
                    <option value="FEMALE">Женский</option>
                </select>
                <input
                    type="date"
                    value={formData.dateOfBirth}
                    onChange={(e) => setFormData({ ...formData, dateOfBirth: e.target.value })}
                    required
                />
                <select
                    value={formData.teamName}
                    onChange={(e) => setFormData({ ...formData, teamName: e.target.value })}
                >
                    <option value="">Выберите команду</option>
                    {teams.map((team, index) => (
                        <option key={index} value={team.teamName}>{team.teamName}</option>
                    ))}
                </select>
                <input
                    placeholder="Новая команда"
                    value={newTeam}
                    onChange={(e) => setNewTeam(e.target.value)}
                />
                <select
                    value={formData.state}
                    onChange={(e) => setFormData({ ...formData, state: e.target.value })}
                >
                    <option value="RUSSIA">Россия</option>
                    <option value="USA">США</option>
                    <option value="ITALY">Италия</option>
                </select>
                <button type="submit" disabled={loading}>
                    {loading ? 'Добавление...' : 'Добавить'}
                </button>
            </form>
        </div>
    );
};

export default AddPlayerPage;
