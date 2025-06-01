import { useState } from "react";
import "./ProgressPage.css";

function ProgressPage() {
    return (
        <div>
            <h1>Your progress</h1>
            <div className="progress-container">
                <div className="progress-item">
                    <div className="progress-number">10</div>
                    <div className="progress-label">Completed Tasks</div>
                </div>
                <div className="progress-item">
                    <div className="progress-number">5</div>
                    <div className="progress-label">Uncompleted Tasks</div>
                </div>
                <div className="progress-item">
                    <div className="progress-number">66%</div>
                    <div className="progress-label">Completion Rate</div>
                </div>
            </div>
            <div className="skill-container">
                <div className="skill-item">
                    <div className="skill-label">Strongest Skill</div>
                    <div className="skill-value">JavaScript</div>
                </div>
                <div className="skill-item">
                    <div className="skill-label">Weakest Skill</div>
                    <div className="skill-value">Databases</div>
                </div>
            </div>
        </div>
    )
}

export default ProgressPage;