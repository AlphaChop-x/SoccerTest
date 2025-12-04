import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import api from '../services/api';

const EditPlayerPage = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [formData, setFormData] = useState(null);
    const [teams, setTeams] = useState([]);
    const [newTeam, setNewTeam] = useState('');
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        api.get(`/api/players/${id}`)
            .then((res) => setFormData(res.data))
            .catch(() => setError('Ошибка загрузки игрока'));

        api.get('/api/teams')
            .then((res) => setTeams(res.data))
            .catch(() => setError('Ошибка загрузки команд'));
    }, [id]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        try {
            let teamNameToUse = formData.teamName;

            // если введена новая команда — создаём её
            if (newTeam.trim()) {
                await api.post('/api/teams', { teamName: newTeam });
                setTeams([...teams, { teamName: newTeam }]);
                teamNameToUse = newTeam;
                setNewTeam('');
            }

            await api.patch(`/api/players/${id}`, { ...formData, teamName: teamNameToUse });
            alert('Игрок обновлён!');
            navigate('/players');
        } catch (err) {
            setError(err.response?.data?.message || 'Ошибка при обновлении');
        } finally {
            setLoading(false);
        }
    };

    if (!formData) return <div>Загрузка...</div>;

    return (
        <div>
            <h2>Редактировать футболиста</h2>
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
                    {loading ? 'Обновление...' : 'Обновить'}
                </button>
            </form>
        </div>
    );
};

export default EditPlayerPage;
