import React from 'react';
import Carousel from 'react-material-ui-carousel';
import { Paper } from '@mui/material';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCirclePlay } from '@fortawesome/free-solid-svg-icons';
import { Link, useNavigate } from "react-router-dom";
import { Button } from 'react-bootstrap';

const Hero = ({ movies }) => {
  const navigate = useNavigate();

  function reviews(movieId) {
    navigate(`/Reviews/${movieId}`);
  }

  return (
    <Carousel>
      {movies?.map((movie) => {
        const trailerLink = movie.trailerLink || ''; // Add null check here
        return (
          <Paper key={movie.imdbId}>
            <div className="movie-card-container">
              <div className="movie-card" style={{ '--img': `url(${movie.backdrops ? movie.backdrops[0] : ''})` }}>
                <div className="movie-detail">
                  <div className="movie-poster">
                    <img src={movie.poster} alt="" />
                  </div>
                  <div className="movie-title">
                    <h4>{movie.title}</h4>
                  </div>
                  <div className="movie-buttons-container">
                    <Link to={`/Trailer/${trailerLink.substring(trailerLink.length - 11)}`}>
                      <div className="play-button-icon-container">
                        <FontAwesomeIcon className="play-button-icon" icon={faCirclePlay} />
                      </div>
                    </Link>
                    <Button variant="info" onClick={() => reviews(movie.imdbId)}>
                      Reviews
                    </Button>
                  </div>
                </div>
              </div>
            </div>
          </Paper>
        );
      })}
    </Carousel>
  );
};

export default Hero;