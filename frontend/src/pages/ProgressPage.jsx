import { useState } from "react";
import "./ProgressPage.css";
import { useNavigate } from "react-router-dom";

function ProgressPage() {
    const [completedNumber, setCompletedNumber] = useState("");
    const [uncompletedNumber, setUncompletedNumber] = useState("");
    const [completionPercentage, setCompletionPercentage] = useState("");
    const [strongestSkill, setStrongestSkill] = useState("");
    const [weakestSkill, setWeakestSkill] = useState("");
    const navigate = useNavigate();

    const handleNavigation = (e) => {
        e.preventDefault();
        navigate("/path");
    }

    return (
        <div>
            <h1>Your progress</h1>
            <button
                onClick={handleNavigation}>
                ← Navigate back to your roadmap
            </button>
            <div className="progress-container">
                <div className="progress-item">
                    <div className="progress-number">{completedNumber}</div>
                    <div className="progress-label">Completed Tasks</div>
                </div>
                <div className="progress-item">
                    <div className="progress-number">{uncompletedNumber}</div>
                    <div className="progress-label">Uncompleted Tasks</div>
                </div>
                <div className="progress-item">
                    <div className="progress-number">{completionPercentage}%</div>
                    <div className="progress-label">Completion Rate</div>
                </div>
            </div>
            <div className="skill-container">
                <div className="skill-item">
                    <div className="skill-label">Strongest Skill</div>
                    <div className="skill-value">{strongestSkill}</div>
                </div>
                <div className="skill-item">
                    <div className="skill-label">Weakest Skill</div>
                    <div className="skill-value">{weakestSkill}</div>
                </div>
            </div>
        </div>
    )
}

export default ProgressPage;