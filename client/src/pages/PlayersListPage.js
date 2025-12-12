import {useNavigate} from 'react-router-dom';
import api from "../services/api";
import {useEffect, useState} from "react";

const PlayersListPage = () => {
    const [players, setPlayers] = useState([]);
    const navigate = useNavigate();
    const handleDelete = async (id) => {
        await api.delete("/api/players/" + id);
        setPlayers((prev) => prev.filter((p) => p.id !== id));
    }

    useEffect(() => {
        api.get('/api/players').then((res) => setPlayers(res.data));
    }, []);

    return (
        <table>
            <thead>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Команда</th>
                <th>Дата рождения</th>
                <th>Пол</th>
                <th>Страна</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            {players.map((player) => (
                <tr key={player.id}>
                    <td>{player.firstName}</td>
                    <td>{player.sureName}</td>
                    <td>{player.teamName}</td>
                    <td>{player.dateOfBirth}</td>
                    <td>{player.gender}</td>
                    <td>{player.state}</td>
                    <td>
                        <button onClick={() => navigate(`/players/${player.id}/edit`)}>
                            Редактировать
                        </button>
                    </td>
                    <td>
                        <button onClick={() => handleDelete(player.id)}>
                            Удалить
                        </button>
                    </td>
                </tr>
            ))}
            </tbody>
        </table>

    );
};

export default PlayersListPage;
