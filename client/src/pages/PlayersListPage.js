import { useNavigate } from 'react-router-dom';
import api from "../services/api";
import { useEffect, useState } from "react";

const PlayersListPage = () => {
    const [players, setPlayers] = useState([]);
    const [page, setPage] = useState(0);
    const [size] = useState(10);
    const [totalPages, setTotalPages] = useState(0);

    const navigate = useNavigate();

    const loadPlayers = async (pageNumber) => {
        const res = await api.get('/api/players', {
            params: {
                page: pageNumber,
                size: size
            }
        });

        setPlayers(res.data.content);
        setTotalPages(res.data.totalPages);
        setPage(res.data.number);
    };

    useEffect(() => {
        loadPlayers(0);
    }, []);

    const handleDelete = async (id) => {
        const ok = window.confirm('Точно удалить игрока?');
        if (!ok) return;

        await api.delete('/api/players/' + id);

        loadPlayers(page);
    };

    return (
        <>
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

            <div style={{ marginTop: '16px' }}>
                <button
                    disabled={page === 0}
                    onClick={() => loadPlayers(page - 1)}
                >
                    Назад
                </button>

                <span style={{ margin: '0 12px' }}>
                    Страница {page + 1} из {totalPages}
                </span>

                <button
                    disabled={page + 1 >= totalPages}
                    onClick={() => loadPlayers(page + 1)}
                >
                    Вперёд
                </button>
            </div>
        </>
    );
};

export default PlayersListPage;
