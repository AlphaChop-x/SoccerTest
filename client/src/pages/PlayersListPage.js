import { useNavigate } from 'react-router-dom';
import api from "../services/api";
import {useEffect, useState} from "react";

const PlayersListPage = () => {
    const [players, setPlayers] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        api.get('/api/players').then((res) => setPlayers(res.data));
    }, []);

    return (
        <div>
            <h2>Список футболистов</h2>
            <ul>
                {players.map((player) => (
                    <li key={player.id}>
                        {player.firstName} {player.sureName}
                        <button onClick={() => navigate(`/players/${player.id}/edit`)}>
                            Редактировать
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default PlayersListPage;
